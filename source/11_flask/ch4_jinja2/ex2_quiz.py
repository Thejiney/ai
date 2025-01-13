from flask import Flask, render_template, request
app = Flask(__name__)

@app.route('/',methods=['get','post'])
def index():
    if request.method=='GET':
        no=None
    else:
        no = request.form['no'].strip()
    return render_template('2_quiz.html',
                           no=no)

# 예외처리 페이지와 로깅
@app.errorhandler(404)
def page_not_found(error):
    app.logger.error("없는 페이지입니다")
    return render_template("page_not_found.html"), 404 # 콘솔에 404출력

if __name__=='__main__':
    app.run(debug=True)