var WINDOW_WIDTH = 1024
var WINDOW_HEIGHT = 768
var RADIUS = 8
var MARGIN_TOP = 60
var MARGIN_LEFT = 30

// 注意月份是0-11
const endTime = new Date(2021, 8, 24, 18, 21, 33)
// 检查当前需要显示的倒计时数
var curShowTimeSeconds = 0

window.onload = function () {

    var canvas = document.getElementById('canvas')
    canvas.width = WINDOW_WIDTH
    canvas.height = WINDOW_HEIGHT

    var context = canvas.getContext('2d')

    setInterval(() => {
        // 更新显示秒数
        curShowTimeSeconds = getCurShowTimeSeconds()
        render(context)

    }, 50)

}

function getCurShowTimeSeconds() {
    var curTime = new Date()
    var ret = endTime.getTime() - curTime.getTime()
    ret = Math.round(ret / 1000)

    return ret >= 0 ? ret : 0
}

function render(ctx) {
    // 刷新之前的图像,清除所选区域
    ctx.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT)

    // 通过剩下的秒数，也就是需要显示的秒数转换为小时，分钟和秒
    var hours = parseInt(curShowTimeSeconds / 3600)
    var minutes = parseInt((curShowTimeSeconds - hours * 3600) / 60)
    var seconds = curShowTimeSeconds % 60
    console.log(hours, minutes, seconds)

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


