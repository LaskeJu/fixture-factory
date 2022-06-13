package fixturefactory;

import static org.junit.jupiter.api.Assertions.*;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

class TemplateNameTest {

  @org.junit.jupiter.api.Test
  public void Should_Create_Template_Name_And_Return_Values() {
    Faker faker = new Faker();

    String name = faker.funnyName().name();

    TemplateName templateName = TemplateName.create(name);

    assertSame(name, templateName.getName());
  }

  @org.junit.jupiter.api.Test
  public void Should_Throw_Illegal_Argument_Exception_When_Name_Is_Null() {
    Throwable exception =
        assertThrows(IllegalArgumentException.class, () -> TemplateName.create(null));
    assertEquals("The template name must be a valid string", exception.getMessage());
  }

  @org.junit.jupiter.api.Test
  public void Should_Throw_Illegal_Argument_Exception_When_Name_Length_Is_To_Small() {
    Throwable exception =
        assertThrows(IllegalArgumentException.class, () -> TemplateName.create("a"));
    assertEquals("The template name must have a length of at least 2", exception.getMessage());
  }

  @org.junit.jupiter.api.Test
  public void Should_Throw_Illegal_Argument_Exception_When_Name_Length_Is_To_Long() {
    Throwable exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> TemplateName.create(StringUtils.repeat('a', 256)));
    assertEquals("The template name must have a length of maximum 255", exception.getMessage());
  }
}
