package points;

public class AreaChecker {
    private long startTime;

    public Result handleNumbers(float x, float y, float r) {
        startTime = System.nanoTime();
        boolean hitValue = checkGetInto(x,y,r);
        float time = (float) (System.nanoTime() - startTime);
        return new Result(x, y, r, time, hitValue);
    }

    public boolean checkGetInto(float x, float y, float r) {
        if (checkIntoTriangle(x, y, r) || checkIntoRectangle(x, y, r) || checkIntoCircle(x, y, r)) {
            return true;
        }
        return false;
    }

    public boolean checkIntoTriangle(float x, float y, float r) {
            return x >= 0 && y <= 0 && y >= (x/2 - r/2);
    }

    public boolean checkIntoRectangle(float x, float y, float r) {
        if ((x >= 0 && x <= r) && (y <= r/2 && y >= 0)) {
            return true;
        }
        return false;
    }

    public boolean checkIntoCircle(float x, float y, float r) {
        if (((x >= -r/2 && x <= 0) && (y <= 0 && y >= -r/2))) {
            if ((x * x + y * y) <= r * r) {
                return true;
            }
        }
        return false;
    }
}