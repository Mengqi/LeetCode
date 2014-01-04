public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = process(path);

        String simplePath = "";
        int remove = 0;
        while(!stack.isEmpty()) {
            String str = stack.pop();
            if (str.equals("/")) {
                // do nothing
            } else if (str.equals("/..")) {
                remove++;
            } else if (str.equals("/.")) {
                // do nothing
            } else {
                if (remove != 0) {
                    remove--;
                } else {
                    simplePath = str + simplePath;
                }
            }
        }

        if (simplePath.length() == 0) {
            simplePath = "/";
        }

        return simplePath;
    }

    private Stack<String> process(String path) {
        Stack<String> stack = new Stack<String>();

        int prevPos = 0;
        for (int i = 1; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == '/') {
                String subStr = path.substring(prevPos, i);
                stack.push(subStr);
                prevPos = i;
            }
        }

        String lastStr = path.substring(prevPos, path.length());
        stack.push(lastStr);

        return stack;
    }
}
