/*■ 题目描述

        【最长的顺子】

        斗地主起源于湖北十堰房县，据说是一位叫吴修全的年轻人根据当地流行的扑克玩法“跑得快”改编的，如今已风靡整个中国，并流行于互联网上。

        牌型：单顺，又称顺子，最少5张牌，最多12张牌(3…A)不能有2，也不能有大小王，不计花色。

        例如： 3-4-5-6-7-8，7-8-9-10-J-Q，3-4-5-6-7-8-9-10-J-Q-K-A

        可用的牌 3<4<5<6<7<8<9<10<J<Q<K<A<2<B(小王)<C(大王)，每种牌除大小王外有四种花色

        (共有13×4+2张牌)

        输入

        手上有的牌
        已经出过的牌(包括对手出的和自己出的牌)
        输出

        对手可能构成的最长的顺子(如果有相同长度的顺子，输出牌面最大的那一个)，
        如果无法构成顺子，则输出 NO-CHAIN。
        输入描述

        输入的第一行为当前手中的牌

        输入的第二行为已经出过的牌

        输出描述

        最长的顺子

        示例1   输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A

        4-5-6-7-8-8-8

        输出

        9-10-J-Q-K-A

        示例2   输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        3-3-3-3-8-8-8-8

        K-K-K-K

        输出

        NO-CHAIN

        说明

        剩余的牌无法构成顺子*/

public class demo06 {
}