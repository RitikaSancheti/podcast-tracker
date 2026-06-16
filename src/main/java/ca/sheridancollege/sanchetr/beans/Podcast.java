package ca.sheridancollege.sanchetr.beans;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PODCAST")
@Builder
public class Podcast {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @Column(name = "`year`")
    private Integer year;
    
    private Double starRating;
    
    private String directLink;
    
    @Builder.Default
    @OneToMany(mappedBy = "podcast", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<StreamingService> streamingServices = new ArrayList<>();

 // Helper method to keep bidirectional relationship in sync
 // Copilot in eclipse helped me with this
    public void addStreamingService(StreamingService service) {
        streamingServices.add(service);
        service.setPodcast(this);
    }
}
