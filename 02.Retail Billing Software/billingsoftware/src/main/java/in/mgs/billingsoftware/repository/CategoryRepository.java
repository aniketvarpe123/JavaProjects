package in.mgs.billingsoftware.repository;

import in.mgs.billingsoftware.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
