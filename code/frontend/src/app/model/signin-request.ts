
export class LoginRequest {
    usernameOrEmail: string;
    password: string;
}

export class JwtAuthenticationResponse {
    accessToken: string;
    tokenType: string;
}
