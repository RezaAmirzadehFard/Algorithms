public class NQueen {
    private static int[] b = new int[25]; // آرایه برای ذخیره موقعیت وزیرها
    private static int solutionCount = 0; // شمارنده تعداد راه‌حل‌ها

    // تابع برای بررسی ایمن بودن قرار دادن وزیر در سطر y و ستون x
    private static boolean isSafe(int y, int x) {
        for (int i = 0; i < y; i++) {
            if (b[i] == x || Math.abs(b[i] - x) == Math.abs(i - y)) {
                return false; // اگر وزیرها یکدیگر را تهدید کنند
            }
        }
        return true; // اگر جایگاه ایمن باشد
    }

    // تابع بازگشتی برای حل مسئله
    private static void solve(int y) {
        if (y == 8) { // اگر همه وزیرها قرار گرفته‌اند
            solutionCount++;
            return;
        }

        for (int x = 0; x < b.length; x++) { // امتحان کردن تمام ستون‌ها
            if (isSafe(y, x)) { // اگر جایگاه ایمن باشد
                b[y] = x; // قرار دادن وزیر در ستون x از سطر y
                solve(y + 1); // رفتن به سطر بعدی
            }
        }
    }


    // تابع اصلی
    public static void main(String[] args) {
        solve(0);

        System.out.println(NQueen.solutionCount);
    }
}