public class Solution {
    public String convert(String s, int nRows) {
        if (nRows <= 1 || s.length() == 0)
             return s;

          String res = "";
          int len = s.length();
          for (int i = 0; i < len && i < nRows; ++i)
          {
              int indx = i;
              res += s.charAt(indx);

              for (int k = 1; indx < len; ++k)
              {
                  //第一行或最后一行，使用公式1：
                  if (i == 0 || i == nRows - 1)
                  {
                      indx += 2 * nRows - 2;
                  }
                  //中间行，判断奇偶，使用公式2或3
                  else
                  {
                      if (k%2 !=0)  //奇数位
                          indx += 2 * (nRows - 1 - i);
                      else indx += 2 * i;
                  }

                  //判断indx合法性
                  if (indx < len)
                  {
                      res += s.charAt(indx);
                  }
              }
          }
          return res;
    }
}