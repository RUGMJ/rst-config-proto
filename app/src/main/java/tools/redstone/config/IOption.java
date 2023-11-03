package tools.redstone.config;

public interface IOption<T> {
    void render(Option<T> option);

    ISerializer<T> getSerializer();
}
