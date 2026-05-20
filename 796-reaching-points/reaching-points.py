class Solution(object):
    def reachingPoints(self, sx, sy, tx, ty):
        """
        :type sx: int
        :type sy: int
        :type tx: int
        :type ty: int
        :rtype: bool
        """
        # Work backwards from (tx, ty) to (sx, sy)
        while tx >= sx and ty >= sy:
            if tx == sx and ty == sy:
                return True
                
            if tx > ty:
                # If ty matches sy, we can only subtract ty from tx. 
                # We check if the remaining distance (tx - sx) is a multiple of ty.
                if ty == sy:
                    return (tx - sx) % ty == 0
                tx %= ty
            else:
                # If tx matches sx, we can only subtract tx from ty.
                # We check if the remaining distance (ty - sy) is a multiple of tx.
                if tx == sx:
                    return (ty - sy) % tx == 0
                ty %= tx
                
        return False