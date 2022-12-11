package spring_security_authentication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	// 配置身分驗證
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}

	
	// 配置網路安全
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

	// 配置 HTTP 安全設定檔
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests() // 授權請求
			.anyRequest().authenticated() // 所有的請求都要驗證
			.and().formLogin(); // 利用表單來登入
		
		http.rememberMe()
			.tokenValiditySeconds(3000)
			.key("mykey");
	}
	
}
