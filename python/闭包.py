# 希望一次返回3个函数，分别计算1x1,2x2,3x3:
# def count():
#     fs = []
#     for i in range(1, 4):
#         def f():
#              return i*i
#         fs.append(f)
#     return fs
#
# f1, f2, f3 = count()

# 你可能认为调用f1()，f2()和f3()结果应该是1，4，9，但实际结果全部都是 9（请自己动手验证）。
# 原因就是当count()函数返回了3个函数时，这3个函数所引用的变量 i 的值已经变成了3。由于f1、f2、f3并没有被调用，
# 所以，此时他们并未计算 i*i，当 f1 被调用时：
#
# ​>>> f1()
# 9     # 因为f1现在才计算i*i，但现在i的值已经变为3

# 因此，返回函数不要引用任何循环变量，或者后续会发生变化的变量。

# 正确写法如下：在外侧再包裹一层函数，放入fs的同时运行该函数，并将外部参数i作为形参导入。
# 这样在导入fs的时候就已经计算出了返回值为 i * i
def count():
    fs = []
    for i in range(1, 4):
        def g(x):
            def f():
                return x * x

            return f

        fs.append(g(i))
    return fs


f1, f2, f3 = count()

print(f1(), f2(), f3())
print(f1)