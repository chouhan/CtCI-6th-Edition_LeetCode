import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* https://leetcode.com/problems/find-duplicate-file-in-system/description/
*
* https://leetcode.com/problems/find-duplicate-file-in-system/solution/
*
* */
public class FindDuplicateInFileSystem {
    public List<List<String>> findDuplicate(String[] paths) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            for (int i = 1; i < files.length; i++) {
                int p = files[i].indexOf('(');
                String key = files[i].substring(p);

                if (!map.containsKey(key))
                    map.put(key, new ArrayList<>());

                map.get(key).add(files[0] + "/" + files[i].substring(0, p));
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1)
                result.add(entry.getValue());
        }
        return result;
    }
}
