package ca.sheridancollege.sanchetr.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class StreamingService {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   
    private String name; // e.g., Spotify, Apple Podcasts
    
    private String serviceLink;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "podcast_id")
    @ToString.Exclude // Prevents circular reference errors in logs, Got this from stack overflow
    private Podcast podcast;
    

}
