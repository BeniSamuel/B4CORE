package com.b4music.b4core.controller;

import com.b4music.b4core.dto.UserRegisterDto;
import com.b4music.b4core.model.User;
import com.b4music.b4core.service.UserService;
import com.b4music.b4core.util.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/b4core/v1/users")
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers () {
        return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained users!!!", this.userService.getAllUsers()));
    }

    @GetMapping("/paginated")
    public ResponseEntity<ApiResponse<Page<User>>> getAllPaginatedUsers (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained paginated users!!!", this.userService.getAllUsersPaginated(page, size, sortBy)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById (@PathVariable Long id) {
        User user = this.userService.getUserById(id);
        return user != null ?
                ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained user!!!", user)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to obtain user!!!", null));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<User>>> getUsersByEmail (@RequestParam(required = false) String email) {
        if (email != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained users with email", this.userService.getUsersByEmail(email)));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Obtained users", this.userService.getAllUsers()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<User>> updateUserById (@PathVariable Long id, @RequestBody UserRegisterDto userRegisterDto) {
        User user = this.userService.updateUserById(id, userRegisterDto);
        if (user != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully updated user!!!", user));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Failed to updated user verify inform provided!!!", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteUserById (@PathVariable Long id) {
        return this.userService.deleteUserById(id) ?
                ResponseEntity.ok(new ApiResponse<>(true, "Successfully deleted user!!!", this.userService.deleteUserById(id))) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Failed to delete user!!!", this.userService.deleteUserById(id)));
    }
}
