package fixturefactory;

final class TemplateName {
  private final String name;

  private TemplateName(final String name) {
    this.name = name;
  }

  public static TemplateName create(final String name) {
    if (name == null) {
      throw new IllegalArgumentException("The template name must be a valid string");
    }
    if (name.length() < 2) {
      throw new IllegalArgumentException("The template name must have a length of at least 2");
    }
    if (name.length() > 255) {
      throw new IllegalArgumentException("The template name must have a length of maximum 255");
    }

    return new TemplateName(name);
  }

  public String getName() {
    return name;
  }
}
