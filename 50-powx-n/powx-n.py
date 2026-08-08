class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1.0

        if n < 0:
            x = 1 / x
            n = -n

        result = 1.0

        while n > 0:
            # If n is odd, include the current x
            if n % 2 == 1:
                result *= x

            # Square x for the next bit
            x *= x

            # Divide exponent by 2
            n //= 2

        return result