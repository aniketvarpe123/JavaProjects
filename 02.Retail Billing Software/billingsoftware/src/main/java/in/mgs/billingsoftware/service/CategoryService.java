package in.mgs.billingsoftware.service;

import in.mgs.billingsoftware.dto.CategoryRequest;
import in.mgs.billingsoftware.dto.CategoryResponse;
import java.util.List;

public interface CategoryService
{
    CategoryResponse add(CategoryRequest request);
    List<CategoryResponse> read();
}
