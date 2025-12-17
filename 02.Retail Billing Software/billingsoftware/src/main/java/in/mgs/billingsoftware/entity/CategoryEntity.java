package in.mgs.billingsoftware.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_category")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String categoryId;
    @Column(unique = true)
    private String name;
    private String description;
    private String bgColor;
    private String imgUrl;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
}

/*
Here’s a detailed explanation of **all the annotations** used in your `CategoryEntity` class:

---

## **1. `@Entity`**

* **Package:** `jakarta.persistence.Entity`
* **Purpose:** Marks a class as a **JPA entity**, meaning it will be mapped to a **database table**.
* **Usage:** Every entity class must have this annotation.

```java
@Entity
public class CategoryEntity { ... }
```

---

## **2. `@Table`**

* **Package:** `jakarta.persistence.Table`
* **Purpose:** Specifies the **table name** and additional table-level constraints.
* **Attributes:**

  * `name` → table name in DB.
  * `uniqueConstraints` → can define unique constraints.

```java
@Table(name = "tbl_category")
```

---

## **3. `@Id`**

* **Package:** `jakarta.persistence.Id`
* **Purpose:** Marks the **primary key** of the entity.

```java
@Id
private Long id;
```

---

## **4. `@GeneratedValue`**

* **Package:** `jakarta.persistence.GeneratedValue`
* **Purpose:** Auto-generates the **primary key** value.
* **Attributes:**

  * `strategy = GenerationType.IDENTITY` → DB handles auto-increment.
  * Other strategies: `AUTO`, `SEQUENCE`, `TABLE`.

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

---

## **5. `@Column`**

* **Package:** `jakarta.persistence.Column`
* **Purpose:** Maps a field to a **DB column** and defines column constraints.
* **Common attributes:**

  * `name` → column name.
  * `nullable` → true/false (default true).
  * `unique` → true/false (default false).
  * `updatable` → true/false (if false, column won’t be updated).

```java
@Column(unique = true, nullable = false)
private String name;
```

---

## **6. `@Builder`**

* **Package:** `lombok.Builder`
* **Purpose:** Enables **builder pattern** for the class (fluent API to create objects).

```java
CategoryEntity category = CategoryEntity.builder()
        .name("Electronics")
        .categoryId("CAT001")
        .build();
```

---

## **7. `@Data`**

* **Package:** `lombok.Data`
* **Purpose:** Generates **boilerplate code** automatically:

  * Getters & Setters
  * `toString()`
  * `hashCode()` & `equals()`

```java
@Data
public class CategoryEntity { ... }
```

---

## **8. `@NoArgsConstructor` and `@AllArgsConstructor`**

* **Package:** `lombok.NoArgsConstructor`, `lombok.AllArgsConstructor`
* **Purpose:**

  * `@NoArgsConstructor` → creates default constructor
  * `@AllArgsConstructor` → creates constructor with all fields

```java
@NoArgsConstructor
@AllArgsConstructor
```

> **Important:** Needed when using `@Builder` with JPA entities.

---

## **9. `@CreationTimestamp`**

* **Package:** `org.hibernate.annotations.CreationTimestamp`
* **Purpose:** Automatically sets the **current timestamp** when the entity is **first persisted**.
* **Used With:** `LocalDateTime` or `Timestamp`

```java
@CreationTimestamp
@Column(updatable = false)
private LocalDateTime createdAt;
```

* `updatable = false` ensures the value never changes after creation.

---

## **10. `@UpdateTimestamp`**

* **Package:** `org.hibernate.annotations.UpdateTimestamp`
* **Purpose:** Automatically updates the field with the **current timestamp** whenever the entity is **updated**.

```java
@UpdateTimestamp
private LocalDateTime updatedAt;
```

---

### ✅ Summary of behavior

| Annotation            | Purpose                                                     |
| --------------------- | ----------------------------------------------------------- |
| `@Entity`             | Marks the class as a DB table                               |
| `@Table`              | Sets table name / constraints                               |
| `@Id`                 | Marks primary key                                           |
| `@GeneratedValue`     | Auto-generates primary key                                  |
| `@Column`             | Column properties like unique, nullable                     |
| `@Builder`            | Fluent builder for object creation                          |
| `@Data`               | Auto-generates getters, setters, toString, equals, hashCode |
| `@NoArgsConstructor`  | Default constructor                                         |
| `@AllArgsConstructor` | Constructor with all fields                                 |
| `@CreationTimestamp`  | Auto timestamp on insert                                    |
| `@UpdateTimestamp`    | Auto timestamp on update                                    |

---

If you want, I can also **draw a diagram** showing **how this entity maps to the DB table with timestamps**, so it’s crystal clear visually.

Do you want me to do that?

 */