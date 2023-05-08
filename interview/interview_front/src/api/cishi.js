import requsest from "../js/cishi.js"
export function cishi(a) {
    return requsest({
        url: "http://localhost:3001/users",
        method: "get",
        params: {
            data: a
        }
    })
}