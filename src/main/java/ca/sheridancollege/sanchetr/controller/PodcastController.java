package ca.sheridancollege.sanchetr.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.sanchetr.beans.Podcast;
import ca.sheridancollege.sanchetr.beans.StreamingService;
import ca.sheridancollege.sanchetr.repositories.PodcastRepository;
import ca.sheridancollege.sanchetr.repositories.StreamingServiceRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PodcastController {
	private PodcastRepository podcastRepository;
	private StreamingServiceRepository streamingServiceRepository;
	
	@GetMapping("/")
    public String index(Model model) {
        model.addAttribute("podcastList", podcastRepository.findAllByOrderByTitleAsc());
        if (!model.containsAttribute("podcast")) {
            model.addAttribute("podcast", new Podcast());
        }
        return "index";
    }
	
	
//	References used
	// for @RequestParam(defaultValue = "") = https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html
	// for Podcast existing = https://jakarta.ee/specifications/persistence/3.0/jakarta-persistence-spec-3.0.html
	// used isBlank and split in case if the user enters messy data = https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
	
	@PostMapping("/addPodcast")
	public String addPodcast(@ModelAttribute Podcast podcast, 
	                         @RequestParam(defaultValue = "") String serviceNames,
	                         @RequestParam(defaultValue = "") String serviceLinks) {

	    // 1. while updating, fetch the existing record to preserve existing services
	    if (podcast.getId() != null) {
	        Podcast existing = podcastRepository.findById(podcast.getId()).orElse(podcast);
	        existing.setTitle(podcast.getTitle());
	        existing.setYear(podcast.getYear());
	        existing.setStarRating(podcast.getStarRating());
	        existing.setDirectLink(podcast.getDirectLink());
	        podcast = existing; // Continue with the managed entity
	    }

	    // 2. Handles NEW services (Only runs if serviceNames isn't empty)
	    if (!serviceNames.isBlank()) {
	        String[] names = serviceNames.split(",");
	        String[] links = serviceLinks.split(",");

	        for (int i = 0; i < names.length; i++) {
	            String link = (i < links.length) ? links[i].trim() : "#";
	            podcast.addStreamingService(
	                StreamingService.builder().name(names[i].trim()).serviceLink(link).build()
	            );
	        }
	    }

	    podcastRepository.save(podcast);
	    return "redirect:/";
	}
	    
	    
	
	@GetMapping("/editPodcast")
    public String editPodcast(@RequestParam Long id, Model model) {
        Podcast podcast = podcastRepository.findById(id).orElse(new Podcast());
        model.addAttribute("podcast", podcast); 
        model.addAttribute("podcastList", podcastRepository.findAllByOrderByTitleAsc());
        return "index";
    }

    @PostMapping("/deletePodcast")
    public String deletePodcast(@RequestParam Long id) {
        podcastRepository.deleteById(id);
        return "redirect:/";
    }
	

	@GetMapping("/addPodcast")
	public String addPodcastForm(Model model) {
		model.addAttribute("podcast", new Podcast());
		model.addAttribute("podcastList", podcastRepository.findAllByOrderByTitleAsc());
		return "index";  
	}

	// Sorting queries 
	@PostMapping("/podcast/findByOrderByYearAsc")
	public String findByOrderByYearAsc(Model model) {
		List<Podcast> podcastList = podcastRepository.findAllByOrderByYearAsc();
		model.addAttribute("podcastList", podcastList);
		model.addAttribute("podcast", new Podcast());
		return "index";
	}
	
	@PostMapping("/podcast/findByOrderByStarRatingDesc")
	public String findByOrderByStarRatingDesc(Model model) {
		List<Podcast> podcastList = podcastRepository.findAllByOrderByStarRatingDesc();
		model.addAttribute("podcastList", podcastList);
		model.addAttribute("podcast", new Podcast());
		return "index";
	}

	@PostMapping("/podcast/findAllOrderedByRatingThenTitle")
	public String findAllOrderedByRatingThenTitle(Model model) {
		List<Podcast> podcastList = podcastRepository.findAllOrderedByRatingThenTitle();
		model.addAttribute("podcastList", podcastList);
		model.addAttribute("podcast", new Podcast());
		return "index";
	}
	
}
