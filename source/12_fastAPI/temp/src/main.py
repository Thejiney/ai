import os

from fastapi import FastAPI
from fastapi import Request
from starlette.staticfiles import StaticFiles
from starlette.templating import Jinja2Templates

from database.repository import get_todos, get_todo

app = FastAPI()
BASE_DIR = os.path.dirname(os.path.abspath(__file__)) # 현 폴더의 절대경로
app.mount('/static',
          StaticFiles(directory=os.path.join(BASE_DIR, '../static')),
          name='static')
templates = Jinja2Templates(directory=os.path.join(BASE_DIR,
                                                   '../templates'))
# 데코레이션 C(post), R(get), U(put,patch), D(delete)
@app.get('/')
@app.get('/todos')
async def get_todos_handler(request:Request):
  # 비동기를 기본으로 지원 파이썬 웹 프레임워크
  # MVT 기반의 강력한 파이썬 웹 프레임워크 : 장고(django)
  todos = get_todos()
  return templates.TemplateResponse('todos.html',
                                    {'request':request,
                                     'todos':todos})

@app.get('/todos/{todo_id:int}')
async def get_todo_handler(request:Request, todo_id:int):
  todo = get_todo(todo_id)
  return templates.TemplateResponse('todo.html',
                                    {'request':request,
                                    'todo':todo})