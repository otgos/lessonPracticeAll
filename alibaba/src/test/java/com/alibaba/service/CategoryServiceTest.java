package com.alibaba.service;

import com.alibaba.entity.Category;
import com.alibaba.repository.CategoryRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) //it will initialize all Mocks
class CategoryServiceTest {

    @Mock private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService=new CategoryService();

    private Category category;


    @BeforeEach
    void setUp() {
        category = new Category();
        category.setName("TV");

    }

    @AfterEach
    void tearDown() throws Exception {

    }

    @Test

    void testAddCategoryWhenNameDoesNotExist() {
        //given


        given(categoryRepository.existsByName(category.getName())).willReturn(false);

        //when
        categoryService.addCategory(category);

        //then
        //we need to invoke categoryRepository.save(category)
        ArgumentCaptor<Category> categoryArgumentCaptor =ArgumentCaptor.forClass(Category.class);

        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        Category capturedValue = categoryArgumentCaptor.getValue();
        assertEquals(category, capturedValue);
    }

    @Test
    @DisplayName("Add category Method using actual save method")
    void testAddCategory(){
        //given - precondition

        given(categoryRepository.save(category)).willReturn(category);

        System.out.println(categoryRepository);
        System.out.println(categoryService);

        //when
        Category savedCategory = categoryService.addCategory(category);
        System.out.println(savedCategory);
        //then

        assertThat(savedCategory).isNotNull();

    }

    @Test
    @DisplayName("fma.m")
    void testAddCategoryWhenNameDoesExist() {
        //given


        given(categoryRepository.existsByName(category.getName())).willReturn(true);

        //when


        //then
        assertThatThrownBy(()->categoryService.addCategory(category))
                .isInstanceOf(IllegalArgumentException.class);
                //.hasMessageContaining("")

        // org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
        //            employeeService.saveEmployee(employee);
        //        });
        verify(categoryRepository, never()).save(any());

    }

    @Test
    void testGetAllCategories() {

        //when
        categoryService.getAllCategories();
        //then
        verify(categoryRepository).findAll();

    }

    @Test
    void testGetAllCategories2() {

        //given
        Category category1 = new Category();
        category1.setName("Gadgets");

        given(categoryRepository.findAll()).willReturn(List.of(category, category1));

        //when

        List<Category> categories = categoryService.getAllCategories();

        //then
        assertEquals(2, categories.size());


    }

    @Test
    @Disabled
    void getCategoryById() {
    }

    @Test
    @Disabled
    void deleteCategory() {
    }

    @Test
    @Disabled
    void update() {
    }
}