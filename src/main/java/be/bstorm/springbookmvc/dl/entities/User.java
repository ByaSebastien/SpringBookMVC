package be.bstorm.springbookmvc.dl.entities;

import be.bstorm.springbookmvc.dl.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@AttributeOverride(name = "id",column = @Column(name = "user_id"))
@Table(name = "user_")
@Getter
@NoArgsConstructor @AllArgsConstructor
@ToString(of = {"username"},callSuper = true) @EqualsAndHashCode(of = {"username"},callSuper = true)
public class User extends BaseEntity<Long> implements UserDetails {

    @Column(unique = true, nullable = false,length = 50)
    private String username;

    @Setter
    @Column(nullable = false)
    private String password;

    @Setter
    private boolean enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",joinColumns = @JoinColumn(name = "username"))
    @Column(name = "role")
    private Set<UserRole> roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map( r -> new SimpleGrantedAuthority(r.toString()))
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
