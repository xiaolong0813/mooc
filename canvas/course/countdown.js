var WINDOW_WIDTH = 1024
var WINDOW_HEIGHT = 768
var RADIUS = 8
var MARGIN_TOP = 60
var MARGIN_LEFT = 30

// 注意月份是0-11
const endTime = new Date(2021, 8, 24, 18, 21, 33)
// 检查当前需要显示的倒计时数
var curShowTimeSeconds = 0
// 需要掉落的小球集合
var balls = []
const colors = ["#33B5E5","#0099CC","#AA66CC","#9933CC","#99CC00","#669900","#FFBB33","#FF8800","#FF4444","#CC0000"]

window.onload = function () {

    WINDOW_WIDTH = document.body.clientWidth
    WINDOW_HEIGHT = document.body.clientHeight
    RADIUS = Math.round(WINDOW_WIDTH * 4 / 5 / 108) - 1
    MARGIN_TOP = Math.round(WINDOW_HEIGHT / 5)
    MARGIN_LEFT = Math.round(WINDOW_WIDTH / 10)

    var canvas = document.getElementById('canvas')
    canvas.width = WINDOW_WIDTH
    canvas.height = WINDOW_HEIGHT

    var context = canvas.getContext('2d')

    // 更新显示秒数
    curShowTimeSeconds = getCurShowTimeSeconds()

    setInterval(() => {
        // 如果把下面放到这里面，不太方便在秒数更新的时候触发动画。所以还是放在update里面
        // 既可以在里面监视时间并更新显示，又可以在更新的时候触发动画
        // curShowTimeSeconds = getCurShowTimeSeconds()
        // 渲染更新当前时间
        render(context)
        // 更新动画
        update()

    }, 50)

}

// 计算更新剩下的时间秒数
function getCurShowTimeSeconds() {
    var curTime = new Date()
    var ret = endTime.getTime() - curTime.getTime()
    ret = Math.round(ret / 1000)

    return ret >= 0 ? ret : 0
}

// 更新动画等其他效果
// 思路，维护当前时间和下一次需要显示的时间，将其进行比较，当当前达到下一次时间时，显示动画
function update() {
    // 不断计算当前的秒数，也就是下一次需要显示的
    var nextShowTimeSeconds = getCurShowTimeSeconds()
    var nextHours = parseInt(nextShowTimeSeconds / 3600)
    var nextMinutes = parseInt((nextShowTimeSeconds - nextHours * 3600) / 60)
    var nextSeconds = nextShowTimeSeconds % 60

    // 记录更新前的秒数
    var curHours = parseInt(curShowTimeSeconds / 3600)
    var curMinutes = parseInt((curShowTimeSeconds - curHours * 3600) / 60)
    var curSeconds = curShowTimeSeconds % 60

    // 当当前秒数和之前记录不同时，说明已经到了下一秒，更新当前时间
    if (nextSeconds != curSeconds) {
        // 依次判断时分秒各位数字是否发生改变
        // 小时
        if (Math.floor(nextHours / 10) != Math.floor(curHours / 10)) {
            addBalls(MARGIN_LEFT, MARGIN_TOP, Math.floor(nextHours / 10))
        }
        if (nextHours % 10 != curHours % 10) {
            addBalls(MARGIN_LEFT + (RADIUS + 1) * 15, MARGIN_TOP, nextHours % 10)
        }
        // 分钟
        if (Math.floor(curMinutes / 10) != Math.floor(nextMinutes / 10)) {
            addBalls(MARGIN_LEFT + (RADIUS + 1) * 39, MARGIN_TOP, Math.floor(nextMinutes / 10))
        }
        if (curMinutes % 10 != nextMinutes % 10) {
            addBalls(MARGIN_LEFT + (RADIUS + 1) * 54, MARGIN_TOP, nextMinutes % 10)
        }
        // 秒钟
        if (Math.floor(nextSeconds / 10) != Math.floor(curSeconds / 10)) {
            addBalls(MARGIN_LEFT + (RADIUS + 1) * 78, MARGIN_TOP, Math.floor(nextSeconds / 10))
        }

        if (nextSeconds % 10 != curSeconds % 10) {
            addBalls(MARGIN_LEFT + (RADIUS + 1) * 93, MARGIN_TOP, nextSeconds % 10)
        }

        curShowTimeSeconds = nextShowTimeSeconds
    }

    // 每次刷新都需要更新位置使其移动
    ballsMove()
    console.log(balls.length)

}

function addBalls(x_start, y_start, num) {
    var matrix = digit[num]
    // var radius = 10
    var distance = (RADIUS + 1) * 2

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j]) {
                var ball = {
                    x: x_start + (RADIUS + 1) + distance * j,
                    y: y_start + (RADIUS + 1) + distance * i,
                    r: RADIUS,
                    g: 1.5 + Math.random(),
                    vx: Math.pow(-1, Math.ceil(Math.random() * 1000)) * 4,
                    vy: -3 - Math.random() * 2,
                    color: colors[Math.floor(Math.random() * colors.length)]
                }
                balls.push(ball)
            }
        }
    }
}

// 小球掉落
function ballsMove() {
    // var time = (new Date().getTime() - startTime) / 1000
    var scale = 0.5
    for (let i = 0; i < balls.length; i++) {
        ball = balls[i]
        ball.x += ball.vx

        if (!((ball.y === WINDOW_HEIGHT - ball.r) && ball.vy === 0)) {
            ball.y += ball.vy
            ball.vy += ball.g
        }
        // ball.y += ball.vy
        // ball.vy += ball.g

        // x 方向判断碰撞。走出画面后删去该球。结束该循环
        if (ball.x >= WINDOW_WIDTH + ball.r || ball.x <= -ball.r) {
            // ball.vx = -ball.vx
            balls.splice(i--, 1)
            continue
        }
        // y 方向判断碰撞
        if (ball.y >= WINDOW_HEIGHT - ball.r) {
            ball.y = WINDOW_HEIGHT - ball.r
            // ball.vy = ball.vy * 0.5 < 0.1 ? 0 : -ball.vy * 0.5
            ball.vy = Math.abs(ball.vy * scale) < 2 ? 0 : -ball.vy * scale
        }

        // // 小球相互碰撞
        // for (let j = 0; j < balls.length - 1; j++) {
        //     if (j === i)
        //         continue
        //     var anotherBall = balls[j]
        //     var deltaX = Math.abs(ball.x - anotherBall.x)
        //     var deltaY = Math.abs(ball.y - anotherBall.y)
        //     if (deltaX ** 2 + deltaY ** 2 <= (ball.r + anotherBall.r) ** 2) {
        //         [ball.vx ,anotherBall.vx] = [anotherBall.vx, ball.vx]
        //         // [ball.vy ,anotherBall.vy] = [anotherBall.vy, ball.vy]
        //     }
        // }
    }
}

function render(ctx) {
    // 刷新之前的图像,清除所选区域
    ctx.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT)

    balls.forEach(ball => {
        ctx.fillStyle = ball.color
        ctx.beginPath()
        ctx.arc(
            ball.x,
            ball.y,
            ball.r,
            0,
            Math.PI * 2)
        ctx.closePath()
        ctx.fill()

        // 这里可以直接更新各个小球位置，但是一般render只渲染。不更新数据
        // 所以还是放在update中，再循环更新一次位置
        // ballsMove(ball, ctx)
    })


    // 通过剩下的秒数，也就是需要显示的秒数转换为小时，分钟和秒
    var hours = parseInt(curShowTimeSeconds / 3600)
    var minutes = parseInt((curShowTimeSeconds - hours * 3600) / 60)
    var seconds = curShowTimeSeconds % 60
    // console.log(hours, minutes, seconds)

    // 小时
    // 分每个数字进行渲染
    renderDigit(MARGIN_LEFT, MARGIN_TOP, Math.floor(hours / 10), ctx)
    // 数字留出间距，每个数字加空隙占据15个边长
    renderDigit(MARGIN_LEFT + (RADIUS + 1) * 15, MARGIN_TOP, hours % 10, ctx)
    // 冒号，对应的是digit[10]，这里传入的其实是index
    renderDigit(MARGIN_LEFT + (RADIUS + 1) * 30, MARGIN_TOP, 10, ctx)

    // 分钟。注意这里冒号站9个边长
    renderDigit(MARGIN_LEFT + (RADIUS + 1) * 39, MARGIN_TOP, Math.floor(minutes / 10), ctx)
    renderDigit(MARGIN_LEFT + (RADIUS + 1) * 54, MARGIN_TOP, minutes % 10, ctx)
    renderDigit(MARGIN_LEFT + (RADIUS + 1) * 69, MARGIN_TOP, 10, ctx)

    // 秒钟
    renderDigit(MARGIN_LEFT + (RADIUS + 1) * 78, MARGIN_TOP, Math.floor(seconds / 10), ctx)
    renderDigit(MARGIN_LEFT + (RADIUS + 1) * 93, MARGIN_TOP, seconds % 10, ctx)


}

function renderDigit(x, y, num, ctx) {
    var matrix = digit[num]
    // var radius = 10
    var distance = (RADIUS + 1) * 2

    ctx.fillStyle = "rgb(0, 102, 153)"

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j]) {
                ctx.beginPath()
                ctx.arc(x + (RADIUS + 1) + distance * j,
                        y + (RADIUS + 1) + distance * i,
                    RADIUS, 0, Math.PI * 2)
                ctx.closePath()
                ctx.fill()
            }
        }
    }
}


