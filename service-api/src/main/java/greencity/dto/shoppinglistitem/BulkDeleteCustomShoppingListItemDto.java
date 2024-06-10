package greencity.dto.shoppinglistitem;

import java.util.List;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class BulkDeleteCustomShoppingListItemDto {
    @Valid
    List<@Valid CustomShoppingListItemRequestDto> customShoppingListItems;
}
