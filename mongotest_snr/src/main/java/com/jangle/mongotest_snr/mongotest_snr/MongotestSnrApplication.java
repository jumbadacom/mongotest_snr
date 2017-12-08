package com.jangle.mongotest_snr.mongotest_snr;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

import com.jangle.mongotest_snr.mongotest_snr.api.comment.Comment;
import com.jangle.mongotest_snr.mongotest_snr.api.comment.CommentRepository;
import com.jangle.mongotest_snr.mongotest_snr.api.share.Share;
import com.jangle.mongotest_snr.mongotest_snr.api.share.ShareRepository;
import com.jangle.mongotest_snr.mongotest_snr.api.user.User;
import com.jangle.mongotest_snr.mongotest_snr.api.user.UserRepository;

@SpringBootApplication
public class MongotestSnrApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(MongotestSnrApplication.class, args);

	}

	/* Initializer */
	@Bean
	public CommandLineRunner init(UserRepository userRepository,ShareRepository shareRepository, CommentRepository commentRepository)
	{
		
		 
		return args->{
			
//			List<User> users=userRepository.findByCityAndDistrict("city0","district=2");
			
			List<User> users=userRepository.findByCity(PageRequest.of(0, 3),"city0");
			
			System.out.println("#############################################################################");
			for(User u : users)
			{
				System.out.println(u);
			}
			System.out.println("#############################################################################");
			String email="hacihussam@gicikmail2.com";
			Optional<User> sonuc=userRepository.findByEmail(email);
			
			if(sonuc.isPresent())
			{
				System.out.println("Adam Var");
				return;
			}
			
			DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyyMMdd");
			User u1=new User();
			u1.setEmail(email);
			u1.setBirthDate(LocalDate.parse("19760101", df).atStartOfDay());
			u1.setIsActive(true);
			u1.setUserName("hacihussam2");
			u1.setName("Hacı");
			u1.setLastName("Hussam");
			
			u1=userRepository.insert(u1);
			
			Share s1 = new Share();
			s1.setAuthorUserId(u1.getId());
			
			StringBuilder sb=null;
			Random r = new Random();
			String alphabet = "12345 67890abcçdefg ğhıijklmnoöprsştuüvyz ";
			sb=new StringBuilder();
			for(int i=0; i<256 ; i++)
			{
				sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
			   	
			}
			s1.setExtra1(sb.toString());
			sb=new StringBuilder();
			for(int i=0; i<256 ; i++)
			{
				sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
			   	
			}
			s1.setExtra2(sb.toString());
			sb=new StringBuilder();
			for(int i=0; i<256 ; i++)
			{
				sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
			   	
			}
			s1.setExtra3(sb.toString());
			
			s1.setIsDeleted(false);
			s1.setLikeCount((long) (r.nextInt(79)));
			
			sb=new StringBuilder();
			for(int i=0; i<256 ; i++)
			{
				sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
			   	
			}
			s1.setText(sb.toString());
			
			s1=shareRepository.insert(s1);
			
			
			Comment c1 = new Comment();
			c1.setCommentUserId(u1.getId());
			sb=new StringBuilder();
			for(int i=0; i<256 ; i++)
			{
				sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
			   	
			}
			c1.setText(sb.toString());
			c1.setLikeCount((long) r.nextInt(10));
			c1.setSharedId(s1.getId());
			c1.setIsDeleted(false);
			
			c1=commentRepository.insert(c1);
			
			System.out.println((c1.getId()!=null)?"Başarılı - "+c1.getId():" Başarısız");
			
			};
	}
}
