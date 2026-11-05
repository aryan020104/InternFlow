type DashboardCardProps = {
    title: string
    description: string
    count: string
}



function DashboardCard({title, description,count}: DashboardCardProps){
    return(
        <div className="dashboard-card">
            <h2>{title}</h2>
            <p>{description}</p>
            <span>{count}</span>
        </div>
    )
}
export default DashboardCard