package TestRestProj.RestNew.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalDto {
    private Long id;
    private String name;
    private int age;
    private int weight;
    private List<CategoryDto> categories;
}
