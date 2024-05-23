from flask import Flask, request, jsonify


app = Flask(__name__)

@app.route('/')
def registration():
    return jsonify({
        "message": "Okay"
        }), 200; 
    
    
    
@app.route("/register", methods=["POST"]) 
def register():
    person_data = request.json
    print(person_data)
    return jsonify({
        "message": "okay"
    }), 200
    


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)