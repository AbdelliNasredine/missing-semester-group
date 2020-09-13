package dz.missingsemester.backend.security;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}admin")
//                .roles("ADMIN")
//                .and()
//                .withUser("user")
//                .password("{noop}user")
//                .roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/document/download/*").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/document/upload").hasRole("ADMIN")
//                .antMatchers("/**/*.js", "/**/*.css").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }
//}
