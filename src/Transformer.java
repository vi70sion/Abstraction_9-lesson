import java.util.List;
@FunctionalInterface
public interface Transformer {
    List<String> transform(List<String> list);

}
