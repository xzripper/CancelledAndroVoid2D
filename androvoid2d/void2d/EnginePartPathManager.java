package androvoid2d.void2d;

class EnginePartPathManager {
    public static String accessEnginePart(String enginePart) {
        return (EngineInfo.engineVersionInRelease) ? String.format("androvoid2d.void2d\\%s", enginePart) : String.format("src\\androvoid2d.void2d\\%s", enginePart);
    }

    public static String accessEnginePartWithAbsolutePath(String enginePart) {
        return String.format("%s\\%s", System.getProperty("user.dir"), accessEnginePart(enginePart));
    }
}
