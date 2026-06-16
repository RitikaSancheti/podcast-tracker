package ca.sheridancollege.sanchetr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ca.sheridancollege.sanchetr.beans.Podcast;

public interface PodcastRepository extends JpaRepository<Podcast, Long> {

	
	public  List<Podcast> findAllByOrderByTitleAsc();
	
	public List<Podcast> findAllByOrderByYearAsc();
	
	public List<Podcast> findAllByOrderByStarRatingDesc();
	
	// Custom: average rating desc, then title
	@Query("SELECT p FROM Podcast p ORDER BY p.starRating DESC, p.title ASC")
	List<Podcast> findAllOrderedByRatingThenTitle();
}
