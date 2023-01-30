package kirinman.miniproject_kiosk.entity;


import kirinman.miniproject_kiosk.dto.MenuRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String menuName;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String imageUrl;

    public Menu(MenuRequestDto menuRequestDto){
        this.menuName = menuRequestDto.getMenuName();
        this.price = menuRequestDto.getPrice();
        this.imageUrl = menuRequestDto.getImageUrl();
    }
}
