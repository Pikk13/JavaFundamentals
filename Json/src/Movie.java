import java.util.List;

public record Movie(
        String title,
        int year,
        List<String> cast,
        List<String> genres,
        String href,
        String extract,
        String thumbnail,
        int thumbnailWidth,
        int thumbnailHeight
) {



}
