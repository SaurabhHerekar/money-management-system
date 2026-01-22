package in.saurabh.moneymanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.saurabh.moneymanager.dto.AuthDTO;
import in.saurabh.moneymanager.dto.ProfileDTO;
import in.saurabh.moneymanager.service.ProfileService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    // @PostMapping("/register")
    // public ResponseEntity<ProfileDTO> registerProfile(@RequestBody ProfileDTO profileDTO) {
    //     ProfileDTO registeredProfile = profileService.registerProfile(profileDTO);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(registeredProfile);
    // }

    @PostMapping("/register")
public ResponseEntity<ProfileDTO> registerProfile(@RequestBody ProfileDTO profileDTO) {

    System.out.println("🔥 REGISTER API HIT 🔥");

    ProfileDTO registeredProfile = profileService.registerProfile(profileDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(registeredProfile);
}


    @GetMapping("/activate")
    public ResponseEntity<String> activateProfile(@RequestParam String token) {
        boolean isActivated = profileService.activateProfile(token);
        if (isActivated) {
            return ResponseEntity.ok("Profile activated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activation token not found or already used");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody AuthDTO authDTO) {
        try {
            if (!profileService.isAccountActive(authDTO.getEmail())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of(
                        "message", "Account is not active. Please activate your account first."
                ));
            }
            Map<String, Object> response = profileService.authenticateAndGenerateToken(authDTO);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "message", e.getMessage()
            ));
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<ProfileDTO> getPublicProfile() {
        ProfileDTO profileDTO = profileService.getPublicProfile(null);
        return ResponseEntity.ok(profileDTO);
    }
}
