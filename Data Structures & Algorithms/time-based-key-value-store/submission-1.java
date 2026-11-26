class TimeMap {

    // Stores one value along with its timestamp.
    static class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    // Each key can have multiple timestamp-value pairs.
    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        // Create a list when we see this key for the first time.
        map.putIfAbsent(key, new ArrayList<>());

        // Timestamps are increasing, so adding at the end keeps the list sorted.
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {

        // If the key was never stored, there is no value to return.
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;

        // Empty string means we haven't found a valid timestamp yet.
        String result = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            Pair current = list.get(mid);

            // This timestamp is valid because it is not after
            // the requested timestamp.
            if (current.timestamp <= timestamp) {

                result = current.value;

                // There may be another valid timestamp closer
                // to the requested timestamp on the right.
                left = mid + 1;

            } else {

                // This timestamp is too large, so search earlier timestamps.
                right = mid - 1;
            }
        }

        return result;
    }
}