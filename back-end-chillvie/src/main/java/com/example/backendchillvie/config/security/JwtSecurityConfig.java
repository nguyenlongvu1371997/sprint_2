package com.example.backendchillvie.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Autowired
    private UserDetailsService jwtUserDetailService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().cors().and()
                .authorizeRequests()
                .antMatchers(
                        //All role
                        "/api/user/login-by-user/**",
                        "/api/movie/showing",
                        "/api/showtimes/movie",
                        "/api/showtimes/showtime",
                        "/api/user/user-name",
                        "/api/movie/showing-movie",
                        "/api/movie/upcoming-movie",
                        "/api/movie/movie",
                        "/api/showtimes/movie-next-day",
                        "/api/showtimes/movie-next-next-day"
                ).permitAll()
                .antMatchers(
                        "/api/seat/showtime",
                        "api/ticket/ticket/**",
                        "/api/ticket/history-ticket",
                        "api/ticket/check-ticket/**"

                ).hasAnyAuthority("ROLE_Customer")
//                .antMatchers(
//                        "/api/carts/getMedicine/**",
//                        "/api/carts/getAllCartDetailsByUser/**",
//                        "/api/carts/getPrescriptionByName/**",
//                        "/api/carts/getPrescriptionBySymptoms/**",
//                        "/api/carts/getIndication/**",
//                        "/api/carts/getNameEmployee/**",
//                        "/api/carts/getOneMedicineByName/**",
//                        "/api/carts/delete-multi/**",
//                        "/prescription/**",
//                        "/prescription/create/**",
//                        "/prescription/{id}/**",
//                        "/prescription/delete/{id}/**",
//                        "/prescription/edit/**"
//
//
//                        )
//                .hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_EMPLOYEE")
//                .antMatchers(
//                        //Authen Role admin and manager
//                        "/api/user/register-by-manager/**",
//                        "/api/invoice/**",
//                        "/api/invoice/result/**",
//                        "/api/invoice/delete/{id}/**",
//                        "/api/invoice/search/**",
//                        "/api/invoice/search/result/**",
//                        "/api/invoice/detail/{id}/**",
//                        "/api/invoice/create/**",
//                        "/api/invoice/{invoiceId}/**",
//                        "/api/invoice/edit/**",
//                        "/api/invoice/code/**",
//                        "/api/invoice-detail/{invoiceId}/**",
//
//                        "/api/kindOfMedicines/**",
//                        "/api/kindOfMedicines/kindOfMedicine/{id}/**",
//                        "/api/kindOfMedicines/delete/{id}/**",
//                        "/api/kindOfMedicines/delete-items/**",
//                        "/api/kindOfMedicines/create/**",
//                        "/api/kindOfMedicines/edit/**",
//                        "/api/kindOfMedicines/get/**",
//                        "/api/kindOfMedicines/get/**",
//
//                        "/api/medicine/code/create/**",
//                        "/api/medicine/{id}/**",
//                        "/api/medicine/**",
//                        "/api/medicine/get-medicine/**",
//                        "/api/medicine/search/**",
//                        "/api/medicine/get-list/**",
//                        "/api/medicine/get-medicine/{id}/**",
//                        "/api/medicine/get-unitDetail/{id}/**",
//                        "/api/medicine/get-list-for-invoice/**",
//
//                        "/customers/api/dto/create/**",
//                        "/customers/api/create/**",
//                        "/customers/api/{id}/**",
//                        "/customers/api/list/**",
//                        "/customers/api/delete/{id}/**",
//                        "/customers/api/update/{id}/**",
//
//                        "/api/supplier/**",
//                        "/api/supplier/delete/{id}/**",
//                        "/api/supplier/create-supplier/**",
//                        "/api/supplier/update-supplier/{id}/**",
//                        "/api/supplier/detail-supplier/{id}/**",
//                        "/api/supplier/get/{id}/**",
//                        "/api/supplier/get-detail/{id}/**",
//                        "/api/supplier/list/**",
//
//
//                        "/api/employees/create/**",
//                        "/api/employees/{id}/**",
//                        "/api/employees/update/{id}/**",
//                        "/api/employees/list/{page}/{limit}/{sort}/**",
//                        "/api/employees/list1/{page}/{limit}/{sort}/**",
//                        "/api/employees/delete-employee/**",
//                        "/api/employees/by-user/{username}/**",
//
//
//                        "/indication/{id}/**",
//                        "/indicationDto/{id}/**",
//                        "/indication/delete/{id}/**",
//                        "/indication/create/**",
//                        "/indication/edit/**",
//
//
//                        "/patient/**",
//
//                        "/api/report/general/**",
//                        "/api/report/chart/revenue/**",
//                        "/api/report/chart/profit/**",
//                        "/api/report/sum/**"
//
//                ).hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
//
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().
                sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

//        httpSecurity
//                .authorizeRequests()
//                .anyRequest().permitAll()
//                .and()
//                .csrf().disable();
    }

}
