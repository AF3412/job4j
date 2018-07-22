package ru.af3412.map;

public class HashCodeClass {
    private boolean booleanValue = true;
    private char charValue = 'd';
    private String stringValue = "HashCodeClass";
    private long longValue = 34829245849498300L;
    private float floatValue = 345832400.93f;
    private double doubleValue = 98584292348454.9834;
    private byte[] arrayValue = {1, 2, 3};

    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + (booleanValue ? 1 : 0);
        result = 31 * result + (int) charValue;
        result = 31 * result + (stringValue == null ? 0 : stringValue.hashCode());
        result = 31 * result + (int) (longValue - (longValue >>> 32));
        result = 31 * result + Float.floatToIntBits(floatValue);
        long longBits = Double.doubleToLongBits(doubleValue);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        for (byte b : arrayValue) {
            result = 31 * result + (int) b;
        }
        return result;
    }
}
