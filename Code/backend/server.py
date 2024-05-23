from flask import Flask, request, jsonify


app = Flask(__name__)

@app.route('/')
def registration():
    return jsonify({
        "message": "Okay"
        }), 200;  


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)