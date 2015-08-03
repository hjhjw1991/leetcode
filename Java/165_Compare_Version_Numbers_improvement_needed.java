public class Solution {
    public int compareVersion(String version1, String version2) {
		String[] v11=version1.split("\\.");
		String[] v22=version2.split("\\.");

		int i, s = 0;
		int l, r;
		for (i = 0; i < v11.length && i < v22.length; i++) {
			l = Integer.valueOf(v11[i]);
			r = Integer.valueOf(v22[i]);
			if (l == r)
				continue;
			else if (l > r) {
				s = 1;
				break;
			} else {
				s = -1;
				break;
			}
		}
		if(s!=0)return s;
		String[] res=null;
		if(v11.length<v22.length){
			res=v22;
			s=-1;
		} else if (v11.length > v22.length) {
			res = v11;
			s = 1;
		} else
			return s;
		for (;i < res.length;i++) {
			if (Integer.valueOf(res[i]) != 0) {
				break;
			}
		}
		if (i == res.length)
			s = 0;
		return s;
    }
}