package in.mgs.billingsoftware.service.impl;

import in.mgs.billingsoftware.entity.CategoryEntity;
import in.mgs.billingsoftware.dto.CategoryRequest;
import in.mgs.billingsoftware.dto.CategoryResponse;
import in.mgs.billingsoftware.repository.CategoryRepository;
import in.mgs.billingsoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository ;

    @Override
    public CategoryResponse add(CategoryRequest request) {
        CategoryEntity newCategory = convertToEntity(request);
        newCategory = categoryRepository.save(newCategory);
        return convertTOResponce(newCategory);
    }
    private CategoryEntity convertToEntity(CategoryRequest request) {
        return CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgColor(request.getBgColor())
                .build();
    }
    private CategoryResponse convertTOResponce(CategoryEntity newCategory) {
        return CategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgColor(newCategory.getBgColor())
                .imgUrl(newCategory.getImgUrl())
                .createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt())
                .build();
    }
    @Override
    public List<CategoryResponse> read() {
        return  categoryRepository.findAll()
                .stream()
                .map(categoryEntity -> convertTOResponce(categoryEntity))
                .collect(Collectors.toList());
    }
}
