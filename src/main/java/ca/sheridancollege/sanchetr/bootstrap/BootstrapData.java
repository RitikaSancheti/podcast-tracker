package ca.sheridancollege.sanchetr.bootstrap;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.sanchetr.beans.Podcast;
import ca.sheridancollege.sanchetr.beans.StreamingService;
import ca.sheridancollege.sanchetr.repositories.PodcastRepository;
import ca.sheridancollege.sanchetr.repositories.StreamingServiceRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private final PodcastRepository podcastRepository;
	private final StreamingServiceRepository streamingServiceRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		
		// 1. Creating Podcasts
		Podcast sysk = Podcast.builder()
		        .title("Stuff You Should Know")
		        .year(2008)
		        .starRating(4.8)
		        .directLink("https://www.iheart.com/podcast/105-stuff-you-should-know-26940277/")
		        .build();

		Podcast trueCrime = Podcast.builder()
		        .title("True Crime Garage")
		        .year(2015)
		        .starRating(4.7)
		        .directLink("https://www.truecrimegarage.com/")
		        .build();

		Podcast joeRogan = Podcast.builder()
		        .title("The Joe Rogan Experience")
		        .year(2009)
		        .starRating(4.8)
		        .directLink("https://www.joerogan.com/")
		        .build();

		Podcast theDaily = Podcast.builder()
		        .title("The Daily")
		        .year(2017)
		        .starRating(4.9)
		        .directLink("https://www.nytimes.com/column/the-daily")
		        .build();

		// 2. Adding Services using the helper method
		
		// Stuff You Should Know
		sysk.addStreamingService(StreamingService.builder()
				.name("iHeartRadio")
				.serviceLink("https://www.iheart.com/podcast/105-stuff-you-should-know-26940277/")
				.build());
		
		sysk.addStreamingService(StreamingService.builder()
				.name("Spotify")
				.serviceLink("https://open.spotify.com/show/0ofXAdFIQQRsCYj9754UFx")
				.build());

		// True Crime
		trueCrime.addStreamingService(StreamingService.builder()
				.name("Apple")
				.serviceLink("https://podcasts.apple.com/us/podcast/true-crime-garage/id1062418176")
				.build());
		
		trueCrime.addStreamingService(StreamingService.builder()
				.name("Spotify")
				.serviceLink("https://open.spotify.com/show/1mVErk3lUWvAgRAXHJ67FG")
				.build());

		// Joe Rogan
		joeRogan.addStreamingService(StreamingService.builder()
				.name("Spotify")
				.serviceLink("https://open.spotify.com/show/4rOoJ6Egrf8K2IrywzwOMk")
				.build());
		
		joeRogan.addStreamingService(StreamingService.builder()
				.name("YouTube")
				.serviceLink("https://www.youtube.com/@joerogan")
				.build());

		// The Daily
		theDaily.addStreamingService(StreamingService.builder()
				.name("Apple")
				.serviceLink("https://podcasts.apple.com/us/podcast/the-daily/id1200361736")
				.build());
		
		theDaily.addStreamingService(StreamingService.builder()
				.name("Spotify")
				.serviceLink("https://open.spotify.com/show/3IM0lmZxpFAY7CwMuv9H4g")
				.build());

		// 3. Saving the Podcast
		podcastRepository.saveAll(Arrays.asList(sysk, trueCrime, joeRogan, theDaily));
	}
}
