import turtle

t = turtle.Turtle()
board = turtle.Turtle()
mapSize = 8
turn = -1

def start(): ##검은돌 = 1 흰돌 = 2
    t.penup()
    t.goto(-137.5,0)
    black_stone()
    t.forward(75)
    white_stone()
    t.right(90)
    t.forward(75)
    t.left(90)
    black_stone()
    t.right(180)
    t.forward(75)
    t.right(180)
    white_stone()


def click(x, y):
    t.penup()
    t.goto(x,y)
    (x,y) = t.position()
    t.penup()
    global turn
    for ny in range(mapSize):
        for nx in range(mapSize):
            if x > nx*75-400 and x < (nx+1)*75-400 and y < ny*-75+300 and y > (ny+1)*-75+300 :
                turn *= -1
                t.goto(37.5+75*nx-400, -75-75*ny+300)
                t.pendown()
                if turn == 1:
                    black_stone()
                else :
                    white_stone()

def black_stone():
    t.speed(0)
    t.penup()
    t.begin_fill()
    t.circle(37.5)
    t.fillcolor("black")
    t.end_fill()

def white_stone():
    t.speed(0)
    t.penup()
    t.begin_fill()
    t.circle(37.5)
    t.fillcolor("yellow")
    t.end_fill()

board.hideturtle()
t.hideturtle()

board.penup()
board.goto(-400,300)
board.pendown()
board.speed(0) 
for i in range(4): 
    board.forward(600) 
    board.right(90) 
a = 0 
b = 0 
for i in range(8):
    if(b == 0):
        a=1
    else:
        a=0
    for j in range(8): 
        board.penup()
        board.goto(j*75-400, i*75*(-1)+300)
        board.pendown()
        for k in range(4):
            board.forward(75)
            board.right(90)
    if(b==0):
        b=1
    else:
        b=0

start()

num = turtle.onscreenclick(click)
    
