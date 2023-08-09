package scrumbackend.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

  @Value("${jwt.secretKey}")
  private String jwtSecretKey;

  public String extractUsername(String jwtToken) {
    return null;
  }

  private Claims extractAllClaims(String jwtToken) {
    return Jwts
      .parserBuilder()
      .setSigningKey(getSigningKey())
      .build()
      .parseClaimsJws(jwtToken)
      .getBody();
  }

  private Key getSigningKey() {
    byte[] jwtSecretKeyBytes = Decoders.BASE64.decode(jwtSecretKey);
    return Keys.hmacShaKeyFor(jwtSecretKeyBytes);
  }
}
