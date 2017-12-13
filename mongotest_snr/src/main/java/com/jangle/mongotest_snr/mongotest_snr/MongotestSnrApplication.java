package com.jangle.mongotest_snr.mongotest_snr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.jangle.mongotest_snr.mongotest_snr.api.comment.Comment;
import com.jangle.mongotest_snr.mongotest_snr.api.comment.CommentRepository;
import com.jangle.mongotest_snr.mongotest_snr.api.share.Share;
import com.jangle.mongotest_snr.mongotest_snr.api.share.ShareRepository;
import com.jangle.mongotest_snr.mongotest_snr.api.user.User;
import com.jangle.mongotest_snr.mongotest_snr.api.user.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MongotestSnrApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(MongotestSnrApplication.class, args);

	}
	

	@Bean
	public CommandLineRunner init(UserRepository userRepository, ShareRepository shareRepository,
			CommentRepository commentRepository) {

		return args -> {
			log.info("CommandLineRunner is running");

			// user
			/*
			 * List<Address> addresses = new ArrayList<>(); for (int i = 0; i < 240000; i++)
			 * { Address address = new Address((i % 2 == 0) ? "address_ev" : "address_is",
			 * (long) Math.random() * 1000 + 10000L, "street-" + i, "district=" + i, "city"
			 * + (int) Math.random() * 100, "country " + (int) Math.random() * 100, new
			 * double[] { 38.0 + Math.random() * 3, 26.0 + Math.random() * 5 });
			 * addresses.add(address); } List<AppUser> appUsers = new ArrayList<>();
			 * DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd"); for (int x =
			 * 0; x < 120000; x++) { StringBuilder sbDate = new StringBuilder();
			 * sbDate.append(1925 + (int) (Math.random() * 10) * (int) (Math.random() *
			 * 10)).append("02").append("15"); AppUser appUser = new AppUser();
			 * appUser.setUserName("username_x" + x); appUser.setIsActive(true);
			 * appUser.setBirthDate(LocalDate.parse(sbDate.toString(), df).atStartOfDay());
			 * appUser.setEmail(x + "email@mail.com"); appUser.setLastName("lastName-" + x);
			 * appUser.setAddresses(addresses.subList(x * 2, x * 2 + 2));
			 * appUsers.add(appUser); } //appUsers.forEach(userRepository::insert);
			 * userRepository.saveAll(appUsers); log.info("appusers are saved");
			 */
			/*
			 * 
			 * List<AppUser> users = userRepository.findAll(); // shares Random r = new
			 * Random(); String[] tags = new String[] { "gunaydin", "hello", "hi", "selam",
			 * "tag1", "deneme", "test" }; List<Share> shares = new ArrayList<>(); for (int
			 * y = 0; y < 2000000; y++) { AppUser user = users.get(r.nextInt(users.size() -
			 * 1)); Share share = new Share(); share.setLikeCount((long) r.nextInt(500));
			 * share.setTags(Arrays.copyOfRange(tags, 0, r.nextInt(tags.length - 1)));
			 * share.setIsDeleted(false); share.setAuthorUserId(user.getId());
			 * share.setText("sample text " + ((char) (48 + r.nextInt(48))) +
			 * " .AnonymousAuthenticationFi org.springframework.security.web.session.Session"
			 * ); share.
			 * setExtra1("Extra text for testing....Registering beans for JMX exposure on startup"
			 * ); share.
			 * setExtra2("Extra text for testing....Tomcat started on port(s): 8083 (http) with context path"
			 * ); share.setExtra3(
			 * "Extra text for testing....Started Mongotest4Application in 19.311 seconds (JVM running for 24.898)"
			 * ); shares.add(share); //Share savedShare = shareRepository.insert(share);
			 * //List<String> sId = user.getShareIds(); //sId.add(savedShare.getId());
			 * //user.setShareIds(sId); //userRepository.save(user); }
			 * 
			 * shareRepository.saveAll(shares); log.info("shares are inserted.");
			 */
			// comments

			ClassPathResource resource = new ClassPathResource("static/dictionary_turkish.txt");
			List<String> dicts = new ArrayList<>();
			File file = resource.getFile();
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = br.readLine()) != null) {
					// process the line.
					dicts.add(line);
				}
			}
			log.info("words count " + dicts.size());

			List<User> users = userRepository.findAll();
			log.info("comments, find all users.");
			Page<Share> sharesList = shareRepository.findAll(PageRequest.of(1100000,1300000));
			List<Share> shares = sharesList.getContent();
			log.info("comments, find all shares.");
			List<Comment> comments = new ArrayList<>();
			Random r2 = new Random();
			
			for (int b = 0; b < 999000; b++) {
				String word1 = dicts.get(r2.nextInt(dicts.size() - 1));
				String word2 = dicts.get(r2.nextInt(dicts.size() - 1));
				String word3 = dicts.get(r2.nextInt(dicts.size() - 1));
				Share share = shares.get(r2.nextInt(shares.size() - 1));
				User user = users.get(r2.nextInt(users.size() - 1));
				Comment comment = new Comment();
				comment.setCommentUserId(user.getId());
				comment.setExtra1(word1+"word thread successfully connected to server with description.");
				comment.setExtra2("Tomcat started on port(s): 8083 (http) with context path."+word2);
				comment.setExtra3("Opened connection [connectionId{localValue:2, serverValue:129}] to 18.194.249.192:27017.");
				comment.setExtra4("Discovered cluster type of STANDALONE");
				comment.setExtra5("Registering beans for JMX exposure on startup");
				comment.setIsDeleted(false);
				comment.setLikeCount((long) r2.nextInt(100));
				comment.setText("comment text  Use copyOfRange method from java.util.Arrays. search for " + word3 + " in the comment.");
				comment.setSharedId(share.getId());
				comments.add(comment);
			}
			log.info("comments inserting has been started.");

			commentRepository.saveAll(comments);

			log.info("comments are inserted.");
			

		};

	}

	// Initializer 
/*	@Bean
	public CommandLineRunner init(TemplateUserRepository userRepository,ShareRepository shareRepository, CommentRepository commentRepository)
	{
		
		 
		return args->{
			
//			List<User> users=userRepository.findByCityAndDistrict("city0","district=2");
			
			List<TemplateUser> users=userRepository.findByCity(PageRequest.of(0, 3),"city0");
			
			System.out.println("#############################################################################");
			for(TemplateUser u : users)
			{
				System.out.println(u);
			}
			System.out.println("#############################################################################");
			String email="hacihussam@gicikmail2.com";
			Optional<TemplateUser> sonuc=userRepository.findByEmail(email);
			
			if(sonuc.isPresent())
			{
				System.out.println("Adam Var");
				return;
			}
			
			DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyyMMdd");
			TemplateUser u1=new TemplateUser();
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
	}*/
}
