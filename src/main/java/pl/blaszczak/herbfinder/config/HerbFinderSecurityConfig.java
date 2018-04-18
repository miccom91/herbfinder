package pl.blaszczak.herbfinder.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@AllArgsConstructor
public class HerbFinderSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user").hasAuthority("ADMIN")
                .antMatchers("/attribute/create").hasAuthority("ADMIN")
                .antMatchers("/attribute").hasAnyAuthority("USER","ADMIN")
                .antMatchers("/user/showyou").hasAnyAuthority("USER","ADMIN")
                .antMatchers("/attribute/create").hasAuthority("ADMIN")
                .antMatchers("/attribute").hasAnyAuthority("USER","ADMIN")
                .antMatchers("/attribute/edit/*").hasAuthority("ADMIN")
                .antMatchers("/attribute/delete/*").hasAuthority("ADMIN")
                .antMatchers("/localization").hasAnyAuthority("USER","ADMIN")
                .antMatchers("/localization/create").hasAuthority("USER")
                .and().formLogin().loginPage("/login")
                .and().exceptionHandling().accessDeniedPage("/errors");
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email,password,IS_ACTIVE from user where email=? ")
                .authoritiesByUsernameQuery("select email,TYPE_USER  from user where email=?").passwordEncoder(new BCryptPasswordEncoder(12));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
