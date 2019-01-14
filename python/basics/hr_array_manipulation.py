
#hr - https://www.hackerrank.com/challenges/crush/problem
def array_manipulation(n, queries):
    arr = [0] * (n + 1)
    for query in queries:
        for i in range(query[0], query[1] + 1):
            arr[i] += query[2]

    arr = sorted(arr)
    return arr[-1]


if __name__ == '__main__':

    nm = input().split()

    n = int(nm[0])

    m = int(nm[1])

    queries = []

    for _ in range(m):
        queries.append(list(map(int, input().rstrip().split())))

    result = array_manipulation(n, queries)
    print(result)
