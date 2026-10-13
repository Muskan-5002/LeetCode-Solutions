import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                if (found) {
                    continue;
                }

                for (int j = 0; j < current.length(); j++) {

                    char ch = current.charAt(j);

                    if (ch != '(' && ch != ')') {
                        continue;
                    }

                    String next = current.substring(0, j)
                            + current.substring(j + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            if (found) {
                break;
            }
        }

        return result;
    }

    private boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            } 
            else if (ch == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}